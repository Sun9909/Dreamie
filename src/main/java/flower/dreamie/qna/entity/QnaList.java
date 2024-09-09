package flower.dreamie.qna.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "question")
public class QnaList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 자동 생성(MySQL AUTO_INCREMENT에 대응)

    @Column(nullable = false)
    private Long question_id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 200)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShowType show_type;

    @Column(nullable = false)
    private LocalDateTime write_at;

    @Column(nullable = true)
    private LocalDateTime edit_at;

    @PrePersist
    public void onCreate() {
        this.write_at = LocalDateTime.now();
        this.edit_at = LocalDateTime.now();
    }

    public enum ShowType {
        True,
        False
    }
}