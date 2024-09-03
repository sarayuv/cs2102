import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Examples {
    ElectionData eData;
    public Examples(){
        eData = new ElectionData(new MostFirstVotesStrategy());
    }

    @Test
    public void test_nominate1(){
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
        }
        catch(Exception e){
            fail(e.getMessage());
        }

        assertEquals(Optional.of("bristaco, husky, gompei"), Optional.of(String.join(", ", this.eData.getCandidates())));
    }

    @Test
    public void test_vote1(){
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");
            this.eData.submitVote("gompei", "husky", "bristaco");
        }
        catch(Exception e){
            fail(e.getMessage());
        }

       assertEquals(Optional.of("gompei"), this.eData.calculateWinner());
    }

    @Test(expected=AlreadyNominatedException.class)
    public void test_CandidateAlreadyNominated() throws AlreadyNominatedException{

        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("gompei");


        fail("did not throw exception properly");
    }

    @Test
    public void test_votesMostAgreeableStrategy1() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");

            this.eData.setStrategy(new MostAgreeableStrategy());

            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("husky", "gompei", "bristaco");
        }
        catch(Exception e){
            fail(e.getMessage());
        }

        assertEquals(Optional.of("bristaco"), this.eData.calculateWinner());
    }



    @Test(expected = CandidateNotNominatedException.class)
    public void test_candidateNotNominated() throws CandidateNotNominatedException {
        try {
            this.eData.submitVote("gompei", "husky", "bristaco");
        } catch (MoreThanOnceException e) {
            throw new RuntimeException(e);
        }

        fail("did not throw exception properly");
    }

    @Test
    public void test_votesMostAgreeableStrategy2() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");

            this.eData.setStrategy(new MostAgreeableStrategy());

            this.eData.submitVote("bristaco", "gompei", "husky");
            this.eData.submitVote("bristaco", "gompei", "husky");
            this.eData.submitVote("husky", "gompei", "bristaco");

        }
        catch(Exception e){
            fail(e.getMessage());
        }

        assertEquals(Optional.of("gompei"), this.eData.calculateWinner());
    }

    @Test
    public void test_14autograder() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");

            this.eData.setStrategy(new MostFirstVotesStrategy());

            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("husky", "bristaco", "gompei");
            this.eData.submitVote("bristaco", "gompei", "husky");
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals(Optional.empty(), this.eData.calculateWinner());
    }

    @Test(expected=CandidateNotNominatedException.class)
    public void test_12autograder() throws CandidateNotNominatedException, AlreadyNominatedException, MoreThanOnceException {
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("husky");

        this.eData.submitVote("gompei", "husky", "bristaco");

        fail("did not throw exception properly");
    }

    @Test(expected=CandidateNotNominatedException.class)
    public void test_notNominated3() throws CandidateNotNominatedException, AlreadyNominatedException, MoreThanOnceException {
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("husky");

        this.eData.submitVote("bristaco", "husky", "gompei");

        fail("did not throw exception properly");
    }

    @Test(expected=CandidateNotNominatedException.class)
    public void test_notNominated4() throws CandidateNotNominatedException, AlreadyNominatedException, MoreThanOnceException {
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("husky");

        this.eData.submitVote("gompei", "bristaco", "husky");

        fail("did not throw exception properly");
    }

    @Test(expected=MoreThanOnceException.class)
    public void test_voteMTO() throws CandidateNotNominatedException, AlreadyNominatedException, MoreThanOnceException {
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("husky");
        this.eData.nominateCandidate("bristaco");

        this.eData.submitVote("gompei", "gompei", "bristaco");

        fail("did not throw exception properly");
    }

    @Test(expected=MoreThanOnceException.class)
    public void test_voteMTO2() throws CandidateNotNominatedException, AlreadyNominatedException, MoreThanOnceException {
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("husky");
        this.eData.nominateCandidate("bristaco");

        this.eData.submitVote("gompei", "gompei", "gompei");

        fail("did not throw exception properly");
    }

    @Test(expected=MoreThanOnceException.class)
    public void test_voteMTO3() throws CandidateNotNominatedException, AlreadyNominatedException, MoreThanOnceException {
        this.eData.nominateCandidate("gompei");
        this.eData.nominateCandidate("husky");
        this.eData.nominateCandidate("bristaco");

        this.eData.submitVote("bristaco", "gompei", "bristaco");

        fail("did not throw exception properly");
    }

    @Test
    public void test_getCandidateException() throws AlreadyNominatedException, MoreThanOnceException, CandidateNotNominatedException {
        String person = "gompei";
        CandidateNotNominatedException cNNE = new CandidateNotNominatedException(person);
        assertEquals(person, cNNE.getCandidate());
    }

    @Test
    public void test_voteMFV() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");

            this.eData.setStrategy(new MostFirstVotesStrategy());

            this.eData.submitVote("gompei", "husky", "bristaco");
            this.eData.submitVote("husky", "bristaco", "gompei");
            this.eData.submitVote("gompei", "bristaco", "husky");
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals(Optional.of("gompei"), this.eData.calculateWinner());
    }

    @Test
    public void test_voteMFVempty() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");

            this.eData.setStrategy(new MostFirstVotesStrategy());

        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals(Optional.empty(), this.eData.calculateWinner());
    }

    @Test
    public void test_voteMAempty() {
        try {
            this.eData.nominateCandidate("gompei");
            this.eData.nominateCandidate("husky");
            this.eData.nominateCandidate("bristaco");

        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals(Optional.empty(), this.eData.calculateWinner());
    }

}
