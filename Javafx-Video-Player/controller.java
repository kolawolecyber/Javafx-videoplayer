package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class controller implements Initializable {
	private File file;
	private Media media;
	private MediaPlayer mediaplayer;

	@FXML
	private MediaView mediaview;
	@FXML
	private Button playButton, pauseButton, resetButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		file = new File("C:/videoplayer/src/application/media.mp4"); // get the file player
		media = new Media(file.toURI().toString()); // convert the file to media
		mediaplayer = new MediaPlayer(media); // send the media into media player
		mediaview.setMediaPlayer(mediaplayer); // make the media to display the media player
	}

	public void playMedia() {
		mediaplayer.play();
	}

	public void pauseMedia() {
		mediaplayer.pause();
	}

	public void resetMedia() {
		if (mediaplayer.getStatus() != MediaPlayer.Status.READY) // make it load and view when reset is pressed
																	// immediately program started
		{

			mediaplayer.seek(Duration.seconds(0.0));
		}
	}
}
