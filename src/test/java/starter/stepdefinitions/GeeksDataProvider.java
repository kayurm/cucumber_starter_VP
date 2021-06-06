package starter.stepdefinitions;

import org.junit.Test;

//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(value="testdata/geeks.csv")
public class GeeksDataProvider {

        private String searchTerm;

        public void setSearchTerm(String searchTerm) {
            this.searchTerm = searchTerm;
        }

        public String getSearchTerm() {
            return searchTerm;
        }

        @Test
        public void data_driven_test() {
            System.out.println("SEARCH TERM: "+searchTerm);
        }

}
