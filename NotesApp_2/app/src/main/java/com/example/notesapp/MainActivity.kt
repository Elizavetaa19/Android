import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

private void saveNotes() {
    SharedPreferences sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    Gson gson = new Gson();
    String json = gson.toJson(notesList);
    editor.putString("notes_list", json);
    editor.apply();
}

private void loadNotes() {
    SharedPreferences sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE);
    Gson gson = new Gson();
    String json = sharedPreferences.getString("notes_list", null);
    Type type = new TypeToken<ArrayList<Note>>() {}.getType();
    notesList = gson.fromJson(json, type);
    if (notesList == null) {
        notesList = new ArrayList<>();
    }
}