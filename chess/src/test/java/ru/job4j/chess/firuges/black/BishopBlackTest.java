package ru.job4j.chess.firuges.black;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {
    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position().getX(), is(2));
        assertThat(bishopBlack.position().getY(), is(7));
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        assertThat(bishopBlack.copy(Cell.D3).position().getX(), is(3));
        assertThat(bishopBlack.copy(Cell.D3).position().getY(), is(5));
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = bishopBlack.way(Cell.G5);
        Cell[] result = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, result);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testWayExe() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        bishopBlack.way(Cell.C4);
    }
}