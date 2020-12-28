import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution_베스트앨범 {
	static class Song implements Comparable<Song> {
		int id;
		String genre;
		int play;

		public Song(int id, String genre, int play) {
			this.id = id;
			this.genre = genre;
			this.play = play;
		}

		@Override
		public int compareTo(Solution_베스트앨범.Song o) {
			return -1 * Integer.compare(this.play, o.play);
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map_genres = new HashMap<>(); 		// key : 장르, value : 재생횟수
		ArrayList<Song> songs = new ArrayList<>();

		for (int i = 0, size = genres.length; i < size; i++) {
			map_genres.put(genres[i], map_genres.getOrDefault(genres[i], 0) + plays[i]);
			songs.add(new Song(i, genres[i], plays[i]));
		}

		ArrayList<String> list_genres = sort_genres(map_genres); 	// 재생횟수로 장르 정렬
		Collections.sort(songs); 									// 재생횟수로 노래 정렬
		ArrayList<Integer> list_plays = new ArrayList<Integer>(); 	// 베스트 앨범
		
		for (int i = 0, size = list_genres.size(); i < size; i++) {
			int cnt = 0;

			for (Song song : songs) {
				if (song.genre.equals(list_genres.get(i))) {
					list_plays.add(song.id);
					
					if (++cnt == 2) break;
				}
			}
		}

		int[] answer = new int[list_plays.size()]; // 크기는 장르 * 2가 아님 => 장르의 노래가 1개일 경우도 있음
		int idx = 0;
		for (int id : list_plays) {
			answer[idx++] = id;
		}

		return answer;
	}

	private ArrayList<String> sort_genres(HashMap<String, Integer> map) {
		ArrayList<Entry<String, Integer>> list_entry = new ArrayList<>(map.entrySet());

		Collections.sort(list_entry, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return -1 * Integer.compare(o1.getValue(), o2.getValue());
			}
		});

		ArrayList<String> list_genres = new ArrayList<String>();
		for (Entry<String, Integer> entry : list_entry) {
			list_genres.add(entry.getKey());
		}

		return list_genres;
	}

	public static void main(String[] args) {
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };

		new Solution_베스트앨범().solution(genres, plays);
	}
}