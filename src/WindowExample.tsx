import React from "react";
import { Layout, Row, Col } from "antd";

const { Header, Content } = Layout;

function createButtons(qnt: number) {
    let buttons = [];
    for (let i = 0; i < qnt; i++)
        buttons.push(
            <Row key={i} className="button-container">
                <Col span={24}>
                    <div
                        className={
                            i === 1 ? "button button-selected" : "button"
                        }
                    >
                        <div className="button-title">
                            <span>Operazione {i + 1}</span>
                        </div>
                    </div>
                </Col>
            </Row>
        );

    return buttons;
}

export default function WindowExample() {
    return (
        <div className="window">
            <div className="window-title">Autogenerazione di GUI</div>
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
                                <Col span={6}>{createButtons(6)}</Col>
                                <Col span={18}>
                                    <div className="output-board-container">
                                        <div className="output-board">
                                            <div className="output-board-content">
                                                Hai selezionato l'
                                                <strong>operazione 2</strong>.
                                                <br />
                                                <em>
                                                    Seleziona tutte le classi in
                                                    cui insegna un determinato
                                                    insegnante.
                                                </em>
                                                <br />
                                                <br />
                                                Insegnante selezionato:{" "}
                                                <strong>
                                                    {" "}
                                                    Professore_ID 17
                                                </strong>
                                                <br />
                                                <br />
                                                L'insegnante ID 17 insegna nelle
                                                classi: <br />
                                                -- <strong>(3, A)</strong>{" "}
                                                <br /> --{" "}
                                                <strong>(5, F)</strong>
                                                <br /> --{" "}
                                                <strong>(1, C)</strong>
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
