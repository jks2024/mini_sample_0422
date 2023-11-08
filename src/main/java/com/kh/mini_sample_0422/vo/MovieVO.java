package com.kh.mini_sample_0422.vo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieVO {
    private String rank;
    private String image;
    private String title;
    private String score;
    private String rate;
    private String reservation;
    private String date;
    @Override
    public String toString() {
        return "MovieVO{" +
                "rank=" + rank +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", rate=" + rate +
                ", reservation=" + reservation +
                ", date=" + date +
                '}';
    }
}
