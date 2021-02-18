import React from "react";
import { Layout, Row, Col } from "antd";

const { Header, Content, Sider } = Layout;

function createButtons(qnt: number) {
    let buttons = [];
    for (let i = 0; i < qnt; i++)
        buttons.push(
            <Row className="button-container">
                <Col span={24}>
                    <div className="button">
                        <div className="button-title">Operazione {i + 1}</div>
                    </div>
                </Col>
            </Row>
        );

    return buttons;
}

export default function Window(props: {
    title?: string;
    backgroundColor?: string;
}) {
    return (
        <div className="window">
            <div className="window-title">{props.title}</div>
            <div className="window-frame">
                <Layout className="window-frame-container">
                    <Header className="window-frame-header"></Header>
                    <Content className="window-frame-content-container">
                        <div className="window-frame-content">
                            <Row gutter={16}>
                                <Col span={6}>{createButtons(6)}</Col>
                                <Col span={18}>
                                    <div className="output-board">
                                        <div className="output-board-content">
                                            Something goes here...
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
