package com.example.demo.wxentity;

import lombok.*;

/**
 * Created by za-lijunnan on 2018/8/24.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestMessage {
    private String toUserName;
    private String fromUserName;
    private String createTime;
    private String msgType;
    private String content;
}
