public class AddEditNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextContent;
    private boolean isEditMode;
    private int noteIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextContent = findViewById(R.id.edit_text_content);

        // Получаем данные, если это режим редактирования
        Intent intent = getIntent();
        isEditMode = intent.getBooleanExtra("isEditMode", false);

        if (isEditMode) {
            noteIndex = intent.getIntExtra("noteIndex", -1);
            Note note = MainActivity.notesList.get(noteIndex);
            editTextTitle.setText(note.getTitle());
            editTextContent.setText(note.getContent());
        }

        findViewById(R.id.button_save).setOnClickListener(v -> saveNote());
    }

    private void saveNote() {
        Intent data = new Intent();
        data.putExtra("title", editTextTitle.getText().toString());
        data.putExtra("content", editTextContent.getText().toString());
        data.putExtra("noteIndex", noteIndex);
        setResult(RESULT_OK, data);
        finish();
    }
}