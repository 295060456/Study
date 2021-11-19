package com.example.cardview;

import java.util.ArrayList;
import java.util.List;

public class MsgLab {

    public static List<Msg> generateMockList(){
        List<Msg> msgList = new ArrayList<>();
        Msg msg1 = new Msg(1,
                R.mipmap.hi,
                "我是王健林",
                "你好许家印");
        msgList.add(msg1);

        Msg msg2 = new Msg(2,
                R.mipmap.www,
                "我是习近平",
                "你好毛政府");
        msgList.add(msg2);

        Msg msg3 = new Msg(3,
                R.mipmap.mjj,
                "我是王岐山",
                "你好哈哈哈哈");
        msgList.add(msg3);

        return msgList;
    }
}
