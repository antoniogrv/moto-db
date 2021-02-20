package builder;

import java.util.ArrayList;

import javax.swing.JTextField;

import endpoint.Actor;

public class QueryBuilder extends Actor {

    private String query;
    private int valuesSize;
    private ArrayList<String> values;
    private String rawQuery;

    public QueryBuilder(String rawQuery) {
        this.rawQuery = rawQuery;
        this.valuesSize = setValuesSize(rawQuery);
        this.values = new ArrayList<String>();
        new ArrayList<JTextField>();
    }

    public void setInputValues(ArrayList<JTextField> inputValues) {
        for (JTextField x : inputValues) {
            if (!x.getText().isEmpty())
                values.add(x.getText());
            debug("?Valore registrato: " + x.getText());
        }

        setQuery();
    }

    public void setQuery() {
        if (!values.isEmpty())
            this.query = injectValues(rawQuery, values);
        else
            this.query = this.rawQuery;

        debug(":Query elaborata: " + this.query);
    }

    public int getValuesSize() {
        return this.valuesSize;
    }

    public String getQuery() {
        return this.query;
    }

    public int setValuesSize(String query) {
        int values = 0;

        if (query.contains("{")) {

            int openBracket = query.indexOf("{");
            int closeBracket = query.indexOf("}");

            while (openBracket >= 0 && closeBracket > 0) {
                openBracket = query.indexOf("{", openBracket + 1);
                closeBracket = query.indexOf("}", closeBracket + 1);
                values++;
            }

        } else
            return 0;

        return values;

    }

    public int[] parseQuery(String query) {
        int[] values = new int[2];

        if (query.contains("{")) {

            int openBracket = query.indexOf("{");
            int closeBracket = query.indexOf("}");

            while (openBracket >= 0 && closeBracket > 0) {
                values[0] = openBracket;
                values[1] = closeBracket;

                openBracket = query.indexOf("{", openBracket + 1);
                closeBracket = query.indexOf("}", closeBracket + 1);
            }

        } else
            return null;

        return values;

    }

    public ArrayList<String> getAliases() {
        StringBuffer buffer = new StringBuffer(this.rawQuery);
        String temp = this.rawQuery;

        ArrayList<String> aliases = new ArrayList<String>();

        int[] x = new int[2];

        while ((x = parseQuery(temp)) != null) {
            aliases.add(this.rawQuery.substring(x[0] + 1, x[1]));
            buffer.replace(x[0], x[1] + 1, "");
            temp = buffer.toString();
        }

        for (String alias : aliases)
            debug("?Alias individuato: " + alias);

        return aliases;
    }

    public String injectValues(String query, ArrayList<String> values) {
        StringBuffer buffer = new StringBuffer(query);
        String temp = query;

        int[] x = new int[2];
        int i = values.size();

        while ((x = parseQuery(temp)) != null) {
            buffer.replace(x[0], x[1] + 1, values.get(--i));
            temp = buffer.toString();
        }

        return temp;
    }

}
