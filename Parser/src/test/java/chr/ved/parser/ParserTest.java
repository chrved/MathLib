package chr.ved.parser;

import chr.ved.parser.core.BaseTest;
import chr.ved.tokenizer.Tokenizer;
import chr.ved.tokenizer.core.type.*;
import chr.ved.tokenizer.core.type.Number;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest extends BaseTest {


    @Test
    public void test1(){
        Parser parser = new Parser(tokenizer);
        String str = "5x^2 -2x +3";
        parser.parse(str);
    }

}