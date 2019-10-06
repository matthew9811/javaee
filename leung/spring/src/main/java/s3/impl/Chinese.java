package s3.impl;

import s3.Axe;
import s3.Person;

/**
 * @Author: matthew
 * @ClassName Chinese
 * @Date: 2019-10-02 15:28
 * @Version: 1.0.0
 * @description:
 */
public class Chinese implements Person {

    private Axe axe;

    public Chinese() {
    }

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    @Override
    public void useAxe() {
        axe.chop();
    }
}
