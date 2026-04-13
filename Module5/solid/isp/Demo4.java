package Module5.solid.isp;

public class Demo4 {
    
}

/**
 * The interface below is too broad. Given the design requirements, how 
 * would you split it?
 */

// BEFORE
interface IMediaPlayer {
    void play(String file);
    void pause();
    void stop();
    void record(String file);
    void convertFormat(String file, String format);
    void streamOnline(String url);
}

class BasicPlayer implements IMediaPlayer {
    public void play(String file) { System.out.println("Playing: " + file); }
    public void pause()           { System.out.println("Paused."); }
    public void stop()            { System.out.println("Stopped."); }
    public void record(String file) {
        throw new UnsupportedOperationException("Cannot record!");
    }
    public void convertFormat(String file, String format) {
        throw new UnsupportedOperationException("Cannot convert!");
    }
    public void streamOnline(String url) {
        throw new UnsupportedOperationException("Cannot stream!");
    }
}

// AFTER
interface IPlayable {
  void play(String file);
  void pause();
  void stop();
}
interface IRecordable {
  void record(String file);
}
interface IConvertible {
  void convertFormat(String file, String format);
}
interface IStreamable {
  void streamOnline(String url);
}

class BasicPlayer implements IPlayable {
  public void play(String file) { ... }
  public void pause()           { ... }
  public void stop()            { ... }
}

class PodcastPlayer implements IPlayable, IRecordable {
  public void play(String file)   { ... }
  public void pause()             { ... }
  public void stop()              { ... }
  public void record(String file) { ... }
}

class StreamingPlayer implements IPlayable, IStreamable {
  public void play(String file)        { ... }
  public void pause()                  { ... }
  public void stop()                   { ... }
  public void streamOnline(String url) { ... }
}

