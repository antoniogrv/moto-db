import React from "react";
import "./App.css";
import WindowExample from "./WindowExample";
import WindowDebug from "./WindowDebug";
import WindowConfig from "./WindowConfig";
import Title from "./Title";
import FastLayout from "./FastLayout";
import {
    BookOutlined,
    DownloadOutlined,
    GithubOutlined,
} from "@ant-design/icons";
import { Route, Switch, HashRouter } from "react-router-dom";
import { Row, Col, Button } from "antd";

export const downloadLink =
    "https://github.com/v1enna/moto-db/archive/master.zip";
export const wikiLink = "https://github.com/v1enna/moto-db/wiki";
export const githubLink = "https://github.com/v1enna/moto-db";

function App() {
    return (
        <HashRouter>
            <Switch>
                <Route path="/">
                    <div className="app">
                        <FastLayout />
                        <Row gutter={16}>
                            <Title />
                            <Col span={1}></Col>
                            <Col span={10}>
                                <div className="mission">
                                    <p className="mission-content">
                                        <strong>
                                            MotoDB è un generatore di
                                            applicazioni grafiche in Java per il
                                            progetto del corso di Basi di Dati
                                        </strong>{" "}
                                        della triennale di Informatica
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
                                <Row gutter={12}>
                                    <Col span={11}>
                                        <Button
                                            onClick={() =>
                                                alert("Non ancora disponibile.")
                                            }
                                            href={downloadLink}
                                            size="large"
                                            icon={<DownloadOutlined />}
                                            className="action-button"
                                            type="primary"
                                        >
                                            Download — &nbsp;
                                            <em>Stable 1.00</em>
                                        </Button>
                                    </Col>
                                    <Col span={11}>
                                        <Button
                                            href={wikiLink}
                                            size="large"
                                            icon={<BookOutlined />}
                                            className="action-button"
                                            type="primary"
                                        >
                                            Documentazione
                                        </Button>
                                    </Col>
                                    <Col span={2}>
                                        <Button
                                            href={githubLink}
                                            size="large"
                                            icon={
                                                <div
                                                    style={{
                                                        marginTop: "-2px",
                                                    }}
                                                >
                                                    <GithubOutlined
                                                        style={{
                                                            fontSize: "25px",
                                                        }}
                                                    />
                                                </div>
                                            }
                                            type="primary"
                                        ></Button>
                                    </Col>
                                </Row>
                            </Col>
                        </Row>
                        <Row className="windows" gutter={24}>
                            <Col span={8}>
                                <WindowExample />
                            </Col>
                            <Col span={8}>
                                <WindowDebug />
                            </Col>
                            <Col span={8}>
                                <WindowConfig />
                            </Col>
                        </Row>
                    </div>
                </Route>
            </Switch>
        </HashRouter>
    );
}

export default App;
