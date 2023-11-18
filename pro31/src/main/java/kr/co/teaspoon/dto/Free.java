package kr.co.teaspoon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Free {
    private int bno;
    private String title;
    private String content;
    private String resdate;
    private String author;
    private int cnt;
    private int rec;
}
