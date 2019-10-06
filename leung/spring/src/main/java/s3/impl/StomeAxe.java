package s3.impl;

import s3.Axe;

/**
 * @Author: matthew
 * @ClassName StomeAxe
 * @Date: 2019-10-02 15:29
 * @Version: 1.0.0
 * @description:
 */
public class StomeAxe implements Axe {

    public StomeAxe() {
    }

    @Override
    public void chop() {
        System.out.println("用斧子大力砍");
    }
}
