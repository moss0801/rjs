package test.com.moss.rjs.code;

import org.junit.Assert;
import org.junit.Test;

public class TopCoder {

    @Test
    public void test() {
        String[] members = new String[] {"BETTY F M A A C C",
                "TOM M F A D C A",
                "SUE F M D D D D",
                "ELLEN F M A A C A",
                "JOE M F A A C A",
                "ED M F A D D A",
                "SALLY F M C D A B",
                "MARGE F M A A C C"};
        String currentUser = "MARGE";
        int sf = 4;
        
        MatchMaker mm = new MatchMaker();
        String[] result = mm.getBestMatches(members, currentUser, sf);
        Assert.assertEquals(2, result.length);
        Assert.assertEquals("JOE", result[0]);
        Assert.assertEquals("TOM", result[1]);
    }
}
    
    
