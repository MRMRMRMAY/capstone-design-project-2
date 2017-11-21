package com.simple.model;

public class Song {
	String song_title;
	String song_singer;
	String song_len;
	String song_uper;
	String song_up_date;
	int song_clik_num;
	public Song() {
		
	}
	public String getSong_title() {
		return song_title;
	}
	public void setSong_title(String song_title) {
		this.song_title = song_title;
	}
	public String getSong_singer() {
		return song_singer;
	}
	public void setSong_singer(String song_singer) {
		this.song_singer = song_singer;
	}
	public String getSong_len() {
		return song_len;
	}
	public void setSong_len(String song_len) {
		this.song_len = song_len;
	}
	public String getSong_uper() {
		return song_uper;
	}
	public void setSong_uper(String song_uper) {
		this.song_uper = song_uper;
	}
	public String getSong_up_date() {
		return song_up_date;
	}
	public void setSong_up_date(String song_up_date) {
		this.song_up_date = song_up_date;
	}
	public int getSong_clik_num() {
		return song_clik_num;
	}
	public void setSong_clik_num(int song_clik_num) {
		this.song_clik_num = song_clik_num;
	}
	@Override
	public String toString() {
		return null;
	}
}
