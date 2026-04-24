package com.back;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    public int count = 0;
    public List<WiseSaying> wiseSayings = new ArrayList<>();

    public WiseSaying save(String content, String author) {
        count++;
        WiseSaying ws = new WiseSaying(count, content, author);
        wiseSayings.add(ws);
        return ws;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById(int id) {
        for (WiseSaying ws : wiseSayings) {
            if (ws.id == id) return ws;
        }
        return null;
    }

    public void remove(WiseSaying ws) {
        wiseSayings.remove(ws);
    }

    public void update(WiseSaying ws) {

    }
}
