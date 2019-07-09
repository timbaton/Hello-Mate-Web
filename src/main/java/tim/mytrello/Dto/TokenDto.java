package tim.mytrello.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import tim.mytrello.entity.Token;

/**
 * Created by timurbadretdinov on May, 2019
 **/

@Data
@AllArgsConstructor
public class TokenDto {

    private String token;

    public static TokenDto from(Token token) {
        return new TokenDto(token.getToken());
    }
}
