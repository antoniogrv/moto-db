import React from "react";
import { Col } from "antd";

export default function Title() {
    return (
        <Col span={10}>
            <div className="about">
                <div className="title">MotoDB</div>
                <div className="motto">
                    <em>do less, do worse.</em>
                </div>
            </div>
        </Col>
    );
}
