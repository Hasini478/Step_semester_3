package oopfundementals.assignment_problems;

class M2 {

    static class Playlist {

        private String[] songs;
        private int count;

        Playlist(int size) {
            songs = new String[size];
            count = 0;
        }

        public void addSong(String song) {

            if (count < songs.length) {
                songs[count] = song;
                count++;
            }
        }

        public String[] getSongs() {

            String[] copy = new String[count];

            for (int i = 0; i < count; i++) {
                copy[i] = songs[i];
            }

            return copy;
        }

        public int getSongCount() {
            return count;
        }
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println(copy[0]);
        System.out.println(copy[1]);

        // Changing the returned array
        copy[0] = "Hacked";

        // Original playlist is not changed
        String[] check = p.getSongs();

        System.out.println(check[0]);
    }
}