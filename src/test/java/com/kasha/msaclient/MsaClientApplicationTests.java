package com.kasha.msaclient;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

import com.u2hee.app.model.Member;

public class MsaClientApplicationTests {

    @Test public void contextLoads() {
        Member member = Member
            .builder()
            .name("test")
            .email("test@abc.com")
            .build();
        System.out.println(member.getName());
		assertThat(1, Is.is(1));
    }

}
