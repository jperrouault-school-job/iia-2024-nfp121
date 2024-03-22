package fr.formation.interpretor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.formation.ObjectMapperFactory;
import fr.formation.model.Photo;

class ExpressionTest {
    @Test
    void shouldReturnTitleByPhoto1() {
        // given
        String value = "get photo 1 title";

        // when
        String result = Interpretor.evaluate(value);

        // then
        Assertions.assertEquals("accusamus beatae ad facilis cum similique qui sunt", result);
    }

    @Test
    void shouldReturnIdByPhoto2() {
        // given
        String value = "GET photo 2 id";

        // when
        String result = Interpretor.evaluate(value);

        // then
        Assertions.assertEquals("2", result);
    }

    @Test
    void shouldReturnJsonByPhoto3() throws JsonProcessingException {
        // given
        String value = "get photo 3";
        Photo photo = new Photo();
        ObjectMapper mapper = ObjectMapperFactory.createObjectMapper();

        photo.setId(3);
        photo.setAlbumId(1);
        photo.setTitle("officia porro iure quia iusto qui ipsa ut modi");
        photo.setUrl("https://via.placeholder.com/600/24f355");
        photo.setThumbnailUrl("https://via.placeholder.com/150/24f355");

        // when
        String result = Interpretor.evaluate(value);

        // then
        Assertions.assertEquals(mapper.writeValueAsString(photo), result);
    }

    @Test
    void shouldReturnTitleByAlbum10() {
        // given
        String value = "get album 10 title";

        // when
        String result = Interpretor.evaluate(value);

        // then
        Assertions.assertEquals("distinctio laborum qui", result);
    }

    @Test
    void shouldReturnUserIdByAlbum5() {
        // given
        String value = "get album 5 userId";

        // when
        String result = Interpretor.evaluate(value);

        // then
        Assertions.assertEquals("1", result);
    }
}
