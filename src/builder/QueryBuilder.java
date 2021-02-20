package builder;

import java.util.ArrayList;

import javax.swing.JTextField;

import endpoint.Actor;

public class QueryBuilder extends Actor {

    private String rawQuery;
    private String query;
    private int valuesSize;
    private String[] values;

    public QueryBuilder(String rawQuery, ArrayList<JTextField> inputValues) {
        this.rawQuery = rawQuery;
        this.valuesSize = getValuesSize(rawQuery);
        this.values = new String[this.valuesSize];

        for (JTextField x : inputValues)
            values[values.length] = x.getText();

        this.query = injectValues(rawQuery, values);

        // new DBHandler(query);
    }

    public static int getValuesSize(String query) {
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

    public static int[] parseQuery(String query) {
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

    public static ArrayList<String> getAliases(String query) {
        StringBuffer buffer = new StringBuffer(query);
        String temp = query;

        ArrayList<String> aliases = new ArrayList<String>();

        int[] x = new int[2];

        while ((x = parseQuery(temp)) != null) {
            aliases.add(query.substring(x[0] + 1, x[1]));
            buffer.replace(x[0], x[1] + 1, "");
            temp = buffer.toString();
        }

        return aliases;
    }

    public static String injectValues(String query, String[] values) {
        StringBuffer buffer = new StringBuffer(query);
        String temp = query;

        int[] x = new int[2];
        int i = 0;

        while ((x = parseQuery(temp)) != null) {
            buffer.replace(x[0], x[1] + 1, values[i++]);
            temp = buffer.toString();
        }

        return temp;
    }

}
