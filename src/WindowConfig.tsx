import React from "react";
import { Layout, Row, Col } from "antd";

const { Header, Content } = Layout;

export default function WindowConfig() {
    return (
        <div className="window">
            <div className="window-title">Fast Config</div>
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
                                                    <span className="filename">
                                                        {">"} Config.java
                                                    </span>
                                                </div>
                                                <br></br>
                                                <div className="line">
                                                    <span className="const">
                                                        DB_NAME = 'scuola'
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="const">
                                                        DB_USERNAME = 'root'
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="const">
                                                        DB_PASSWORD = 'root_psw'
                                                    </span>
                                                </div>
                                                <div className="line">
                                                    <span className="const">
                                                        DARK_MODE = 1
                                                    </span>
                                                </div>
                                                <br></br>
                                                <div className="line">
                                                    <span className="comment">
                                                        /* .01 */&nbsp;
                                                    </span>
                                                    <span className="keyword">
                                                        new
                                                    </span>{" "}
                                                    <span className="class">
                                                        Query
                                                    </span>
                                                    (
                                                    <span className="query">
                                                        'SELECT * FROM utenti
                                                        INNER JOIN clienti'
                                                    </span>
                                                    )
                                                </div>
                                                <div className="line">
                                                    <span className="more">
                                                        ...
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
