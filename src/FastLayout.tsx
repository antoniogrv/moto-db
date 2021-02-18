import React from "react";
import { Button } from "antd";
import Title from "./Title";
import {
    BookOutlined,
    DownloadOutlined,
    GithubOutlined,
} from "@ant-design/icons";
import { downloadLink, githubLink, wikiLink } from "./App";

export default function FastLayout() {
    return (
        <div className="fast-layout">
            <Title />
            <div className="fast-layout-buttons">
                <div className="fast-layout-button-container">
                    <Button
                        disabled
                        href={downloadLink}
                        size="large"
                        icon={<DownloadOutlined />}
                        className="action-button"
                        type="primary"
                    >
                        Download — &nbsp;
                        <em>Stable 1.00</em>
                    </Button>
                </div>
                <div className="fast-layout-button-container">
                    <Button
                        href={wikiLink}
                        size="large"
                        icon={<BookOutlined />}
                        className="action-button"
                        type="primary"
                    >
                        Documentazione
                    </Button>
                </div>
                <div className="fast-layout-button-container">
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
                </div>
            </div>
        </div>
    );
}
