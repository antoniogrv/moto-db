# Consultare la documentazione in caso di dubbio!

/*
	Si invita a seguire, o lanciare cambiando i valori indicati, il seguente layout ..
    .. per creare il database. E' possibile integrare lo snippet nel proprio script SQL.
    
	I valori strettamente necessari, nonché gli stessi adoperati nella demo, sono:
    
    example_database
    example_username
    example_password
*/

USE mysql;
DROP USER IF EXISTS 'example_username'@'localhost';
CREATE USER 'example_username'@'localhost' IDENTIFIED BY 'example_password';
DROP DATABASE IF EXISTS example_database;
CREATE DATABASE example_database;
GRANT ALL ON example_database.* TO 'example_username'@'localhost';
SET SQL_SAFE_UPDATES = 0;
USE example_database;

/*
	Se si intende provare la demo proposta nella configurazione predefinita del software ..
    .. sarà necessario eseguire anche le seguenti query.
*/

/*
	Crea una tabella d'esempio.
*/
CREATE TABLE example_table(
	id int NOT NULL,
	nome varchar(16) NOT NULL,
    cognome varchar(16) NOT NULL,
    
    PRIMARY KEY(id)
);

/*
	Popola la tabella d'esempio con dati predefiniti.
*/
INSERT INTO example_table VALUES 
	(0, "Raffaele", "Zheng"),
	(1, "Mario", "Rossi"),
    (2, "Jolyne", "Kujo"),
    (3, "Francesco", "Rossi");

/*
	Conferma che i dati siano stati inseriti correttamente, visualizzandoli.
*/
SELECT * FROM example_table;


# Possibili operazioni definite sulla realtà d'interesse ...

/*
	Non è necessario inserire il punto e virgola (;) alla fine della query.
	E' possibile sostituire i valori di input richiesti con un alias.
	Esempio > SELECT * WHERE valore = {Il nome del mio valore} AND [..]
 
	L'alias sarà il nome del campo da compilare a schermo al momento dell'inserimento dei dati da parte dell'utente.
	In caso di tipi di dati diversi dai valori numerici (come stringhe e date) sarà necessario inserire degli apici (singoli o doppi)
	.. ed eventuali evaderli. L'operazione 3 ne è un esempio.

	Non c'è un limite di dati in input. In caso di necessità, comparirà una scrollbar sia nel frame principale, ..
	.. sia nel frame di immissione dei dati in input.
*/

/*
	Di seguito sono elencate le operazioni predefinite presenti nella demo del software.
*/

# Operazione 1
# Seleziona tutti i dati di esempio.
# SELECT * FROM example_table

# Operazione 2
# Seleziona solo la colonna 'nome' dai dati d'esempio, in base all'ID.
# SELECT nome FROM example_table WHERE id = {ID Esempio}

# Operazione 3
# Seleziona solo la colonna 'id' dai dati d'esempio, in base al nome e al cognome.
# SELECT id FROM example_table WHERE nome = \"{Nome}\" AND cognome = \"{Cognome}\"
# Si notino i caratteri di escape (\) prima degli apici.

# Operazione 4
# Svuota la tabella d'esempio.
# DELETE FROM example_table