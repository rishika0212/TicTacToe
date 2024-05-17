package com.typhon.tictactoe

data class GameState(
    val playerCircleCount: Int= 0,
    val playerCrossCount: Int=0,
    val drawCount: Int=0,
    val hintText:String="Player 'O' Turn",
    val currentTurn:BoardCellValue=BoardCellValue.CIRCLE,
    val victoryType:VictoryType=VictoryType.NONE,
    val hasWon:Boolean=false
)
enum class BoardCellValue{
    CIRCLE,
    CROSS,
    NONE
}

enum class VictoryType{
    HL1,
    HL2,
    HL3,
    VL1,
    VL2,
    VL3,
    DL1,
    DL2,
    NONE
}