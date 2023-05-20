package stepDefinitions;

import enums.TOAST_MESSAGE;
import enums.USERINFO;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class JavaTrain {
    @Test
    public void lambda() {
        String[] names = {"elma", "armut", "muz"};


        // java 8 oncesi structure programming
        for (int i = 0; i < names.length; i++) {
            Assert.assertTrue(names[i].contains("m"));
        }

        // java 8 sonrasi functional programming lambda

        Assert.assertTrue(Arrays.stream(names).allMatch(t -> t.contains("m")));  // her bir obje m iceriyor mu

        Assert.assertTrue(Arrays.stream(names).anyMatch(t -> t.contains("z")));  // herhangi bir obje z iceriyor mu

        Assert.assertTrue(Arrays.stream(names).noneMatch(t -> t.contains("x")));  // hicbir bir obje x iceriyor mu


    }


    @Test
    public void enumDeneme() {
        System.out.println(TOAST_MESSAGE.EMAIL_1.getToast());

        TOAST_MESSAGE.assertToast(TOAST_MESSAGE.EMAIL_1);

        System.out.println(USERINFO.OMER.getToken());
    }
}
