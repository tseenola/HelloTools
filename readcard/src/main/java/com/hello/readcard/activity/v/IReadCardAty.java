package com.hello.readcard.activity.v;


import com.hello.readcard.read_card_service.CardReader;
import com.hello.readcard.read_pwd.PwdReader;

/**
 * Created by lenovo on 2017/2/24.
 * 描述：读卡
 */

public interface IReadCardAty extends CardReader.OnReadCardFinish, PwdReader.OnEncryPwdFinish{

}