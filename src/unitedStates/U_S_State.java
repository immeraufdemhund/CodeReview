package unitedStates;

/**
 * Created by snyder on 2015-09-29.
 */
    public class U_S_State implements Comparable<U_S_State>{
        private final String stateFlower;
        private final String stateBird;
        private final String stateName;
        private String stateAbbreviation;

        public U_S_State(String stateName){
            this(stateName, "", "");
        }
        public U_S_State(String stateName, String stateFlower, String stateBird) {
            this.stateFlower = stateFlower;
            this.stateBird = stateBird;
            this.stateName = stateName;
        }

        public String getStateAbbreviation() {
            return stateAbbreviation;
        }

        public void setStateAbbreviation(String stateAbbreviation) {
            this.stateAbbreviation = stateAbbreviation;
        }

        public String getStateName() {
            return stateName;
        }

        public String getStateBird() {
            return stateBird;
        }

        public String getStateFlower() {
            return stateFlower;
        }

        @Override
        public int compareTo(U_S_State o) {
            return o.stateName.compareTo(this.stateName);
        }
    }
