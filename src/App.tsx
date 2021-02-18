import React from "react";
import "./App.css";
import Window from "./Window";
import { Route, Switch, HashRouter } from "react-router-dom";
import { Row, Col } from "antd";

function App() {
    return (
        <HashRouter>
            <Switch>
                <Route path="/">
                    <div className="app">
                        <Row gutter={16}>
                            <Col span={10}>
                                <div className="about">
                                    <div className="title">MotoDB</div>
                                    <div className="motto">
                                        <em>do less, worse.</em>
                                    </div>
                                </div>
                            </Col>
                            <Col span={1}></Col>
                            <Col span={10}>
                                <div className="mission">
                                    <p className="mission-content">
                                        <strong>
                                            MotoDB è un generatore di
                                            applicazioni grafiche in Java per il
                                            progetto del corso di Basi di Dati
                                        </strong>{" "}
                                        del secondo semestre di Informatica
                                        all’Università di Salerno. Il software,
                                        per funzionare, ha bisogno
                                        <strong>
                                            {" "}
                                            solo ed esclusivamente delle query
                                        </strong>{" "}
                                        come stringhe, e nient’altro.{" "}
                                        <em>It’s that easy.</em>
                                    </p>
                                </div>
                            </Col>
                        </Row>
                        <Row gutter={24}>
                            <Col span={8}>
                                <Window title="GUI dinamica"></Window>
                            </Col>
                            <Col span={8}>
                                {" "}
                                <Window
                                    backgroundColor="black"
                                    title="Debug dev-friendly"
                                ></Window>
                            </Col>
                            <Col span={8}>
                                {" "}
                                <Window title="Configurazione semplice"></Window>
                            </Col>
                        </Row>
                    </div>
                </Route>
            </Switch>
        </HashRouter>
    );
}

export default App;
