package Units;

import java.util.Random;

public enum Names {
    Abraham, Addison, Adrian, Albert, Alec, Alfred, Alvin, Andrew, Andy, Archibald, Archie, Arlo, Arthur,
    Austen, Barnabe, Bartholomew, Bertram, Chad, Chance, Colin, Curtis, Cuthbert, Daniel, Darryl, David, Donald,
    Douglas, Earl, Ebenezer, Edgar, Edmund, Edward, Edwin, Elliot, Emil, Floyd, Franklin, Frederick, Gabriel,
    Galton, Gareth, George, Gerard, Gilbert, Gorden, Gordon, Graham, Grant, Henry, Hudson, Hugh, Ian, Jack,
    Jaime, James, Jason, Jeffrey, Joey, John, Jonas, Joseph, Joshua, Julian, Justin, Kurt, Lanny, Larry,
    Laurence, Lawton, Lester, Malcolm, Marcus, Mark, Marshall, Martin, Marvin, Matt, Maximilian, Michael,
    Miles, Murray, Myron, Nate, Nathan, Neil, Nicholas, Nicolas, Norman, Oliver, Oscar, Owen, Patrick, Paul,
    Philip, Raymond, Reginald, Rhys, Richard, Robert, Roderick, Rodger, Roger, Ronald, Rowland, Rufus, Russell,
    Sebastian, Simon, Stephen, Thomas, Tobias, Travis, Victor, Vincent, Vivian, Wayne, Wilfred, William, Winston;
    public static String randName() {
        int randIndex = new Random().nextInt(Names.values().length);
        return String.valueOf(Names.values()[randIndex]);
    }
}
