package oodp.assignment_problems;

class Problem2 {

    static String findDuplicateTeam(String[] teamNames) {

        for (int i = 0; i < teamNames.length; i++) {

            for (int j = i + 1; j < teamNames.length; j++) {

                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    static void main() {

        String[] teamNames = {
                "ByteForce",
                "CodeCrafters",
                "ByteForce"
        };

        System.out.println(findDuplicateTeam(teamNames));
    }
}