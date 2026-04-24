package com.back;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    public Scanner sc;
    public WiseSayingService wiseSayingService = new WiseSayingService();

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }

    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying ws = wiseSayingService.write(content, author);
        System.out.println(ws.id + "번 명언이 등록되었습니다.");
    }

    public void list() {
        List<WiseSaying> wiseSayings = wiseSayingService.findAll();
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying ws = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", ws.id, ws.author, ws.content);
        }
    }

    public void delete(String command) {
        int id = Integer.parseInt(command.split("=")[1]);
        WiseSaying ws = wiseSayingService.findById(id);

        if (ws != null) {
            wiseSayingService.remove(ws);
            System.out.println(id + "번 명언이 삭제되었습니다.");
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    public void modify(String command) {
        int id = Integer.parseInt(command.split("=")[1]);
        WiseSaying ws = wiseSayingService.findById(id);

        if (ws != null) {
            System.out.println("명언(기존) : " + ws.content);
            System.out.print("명언 : ");
            String content = sc.nextLine();
            System.out.println("작가(기존) : " + ws.author);
            System.out.print("작가 : ");
            String author = sc.nextLine();

            wiseSayingService.modify(ws, content, author);
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }
}
