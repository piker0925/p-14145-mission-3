package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("등록 명령을 입력하면 명언 번호가 출력된다.")
    void t1() {
        String input = """
                등록
                현재를 사랑하라.
                작자미상
                종료
                """;
        Scanner scanner = TestUtil.genScanner(input);
        
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(scanner).run();

        String out = output.toString();
        
        assertThat(out)
                .contains("명언 :")
                .contains("작가 :")
                .contains("1번 명언이 등록되었습니다.");

        TestUtil.clearSetOutToByteArray();
    }
}
