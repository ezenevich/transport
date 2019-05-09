
package com.board.data;

import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class History {

    private List<Integer> hist = new LinkedList<>();

    public void removeHist(Integer id) {
        hist.remove(id);
    }

    public List<Integer> getHist(){
        return hist;
    }
}
