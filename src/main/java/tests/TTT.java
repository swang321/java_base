package tests;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.extra.qrcode.QrCodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author whh  2019/10/22 17:02
 */
public class TTT {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(String.valueOf(i));
//        }
//
//        for (String s : list) {
//            MyRunner myRunner = new MyRunner(s);
//            ThreadPoolService.execute(myRunner);
//        }
        String buildUrl = UrlBuilder.create().setHost("https://qr.alipay.com/bax0557352fqumekerdy001a").build();
        System.out.println(buildUrl);

        QrCodeUtil.generate("https://qr.alipay.com/bax0557352fqumekerdy001a", 300, 300, FileUtil.file("D:\\mnt\\qrcode.jpg"));

    }
}
