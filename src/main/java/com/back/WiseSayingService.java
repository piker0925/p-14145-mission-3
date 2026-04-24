package com.back;

import java.util.List;

public class WiseSayingService {
    public WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    public WiseSaying write(String content, String author) {
        return wiseSayingRepository.save(content, author);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void remove(WiseSaying ws) {
        wiseSayingRepository.remove(ws);
    }

    public void modify(WiseSaying ws, String content, String author) {
        ws.content = content;
        ws.author = author;
        wiseSayingRepository.update(ws);
    }
}
