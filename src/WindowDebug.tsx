import React from "react";
import { Layout, Row, Col } from "antd";

const { Header, Content } = Layout;

export default function WindowDebug() {
    return (
        <div className="window">
            <div className="window-title">Debug Mode</div>
            <div className="window-frame">
                <Layout className="window-frame-container">
                    <Header className="window-frame-header">
                        <div className="header-content">
                            <span>&bull;&bull;&bull;</span>
                        </div>
                    </Header>
                    <Content className="window-frame-content-container">
                        <div className="window-frame-content">
                            <Row>
                                <Col span={24}>
                                    <div className="output-board-container">
                                        <div className="output-board">
                                            <div className="output-board-content">
                                                <div className="line">
                                                    <span className="neutral">
                                                        <strong>
                                                            {"<Viewer>"}
                                                        </strong>{" "}
                                                        MotoDB avviato
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="good">
                                                        <strong>
                                                            {"<Viewer>"}
                                                        </strong>{" "}
                                                        Configurazione caricata.
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="neutral">
                                                        <strong>
                                                            {"<Viewer>"}
                                                        </strong>{" "}
                                                        Provo a connettermi al
                                                        database 'scuola'...
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="bad">
                                                        <strong>
                                                            {"<DBHandler>"}
                                                        </strong>{" "}
                                                        Connessione falita.
                                                        Ricontrolla i dati.
                                                    </span>
                                                </div>
                                                <div className="line more">
                                                    ...
                                                </div>
                                                <div className="line">
                                                    <span className="good">
                                                        <strong>
                                                            {"<MainFrame>"}
                                                        </strong>{" "}
                                                        GUI generata con
                                                        successo. In attesa
                                                        dell'utente.
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="neutral">
                                                        <strong>
                                                            {"<MainFrame>"}
                                                        </strong>{" "}
                                                        Operazione 4
                                                        selezionata. Genero un
                                                        QueryFrame...
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="good">
                                                        <strong>
                                                            {"<QueryFrame>"}
                                                        </strong>{" "}
                                                        Campi di input generati.
                                                        In attesa dell'utente.
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="neutral">
                                                        <strong>
                                                            {"<QueryFrame>"}
                                                        </strong>{" "}
                                                        Input ottenuto. Richiedo
                                                        di elaborare la query...
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="good">
                                                        <strong>
                                                            {"<QueryBuilder>"}
                                                        </strong>{" "}
                                                        Richiesta ricevuta.
                                                        Elaboro la query...
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="good">
                                                        <strong>
                                                            {"<QueryBuilder>"}
                                                        </strong>{" "}
                                                        Query creata: "SELECT
                                                        studente.nome,
                                                        studente.cognome FROM
                                                        studenti"
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="neutral">
                                                        <strong>
                                                            {"<QueryBuilder>"}
                                                        </strong>{" "}
                                                        Chiedo di eseguire la
                                                        query...
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="neutral">
                                                        <strong>
                                                            {"<DBHandler>"}
                                                        </strong>{" "}
                                                        Richiesta ricevuta.
                                                        Provo ad eseguire la
                                                        query...
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </Col>
                            </Row>
                        </div>
                    </Content>
                </Layout>
            </div>
        </div>
    );
}
