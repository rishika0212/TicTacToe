package com.typhon.tictactoe

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.typhon.tictactoe.ui.theme.Blue
import com.typhon.tictactoe.ui.theme.Gray
import com.typhon.tictactoe.ui.theme.Pinky

@Composable
fun GameScreen(
    viewModel: GameViewModel
){
    val state=viewModel.state
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Gray)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text="Player 'O':${state.playerCircleCount} ",fontSize=16.sp)
            Text(text= "Draw: ${state.drawCount}",fontSize=16.sp)
            Text(text="Player 'X':${state.playerCrossCount} ",fontSize=16.sp)

        }
        Text(
            text="Tic Tac Toe",
            fontSize = 40 .sp,
            fontWeight=FontWeight.ExtraBold,
            fontFamily=FontFamily.Monospace,
            color= Blue
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .clip(RoundedCornerShape(20.dp))
                .background(Gray),
            contentAlignment = Alignment.Center
        ){
            BoardBase()
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3),
            ) {
                viewModel.boardItems.forEach{(cellNo,boardCellValue)->
                    item{
                        Column (
                            modifier= Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null

                                ) {
                                    viewModel.onAction(UserActions.BoardTapped(cellNo))
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ){
                            AnimatedVisibility(
                                visible = viewModel.boardItems[cellNo]!=BoardCellValue.NONE,
                                enter= scaleIn(tween(1000))
                            ) {
                                if(boardCellValue==BoardCellValue.CIRCLE){
                                    Circle()
                                }else if(boardCellValue==BoardCellValue.CROSS){
                                    Cross()
                                }
                                
                            }

                        }
                    }
                }

            }
            Column (
                modifier=Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                AnimatedVisibility(
                    visible = state.hasWon,
                    enter = fadeIn(tween(2000))
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        text = "Game Over!",
                        style = MaterialTheme.typography.displayMedium

                    )
                }
            }

            Column (
                modifier=Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                AnimatedVisibility(
                    visible = state.hasWon,
                    enter = fadeIn(tween(2000))
                ) {
                    DrawVictoryLine(state = state)

                }
            }
        }

        Row(
            modifier=Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text=state.hintText,
                fontSize=24.sp,
                fontStyle = FontStyle.Italic
            )
            Button(
                onClick = {
                          viewModel.onAction(
                              UserActions.PlayAgainButtonClicked
                          )
                },
                shape=RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Pinky,
                    contentColor = Color.White
                ),
                elevation=ButtonDefaults.buttonElevation(
                    defaultElevation = 5.dp
                )

            ) {

                Text(
                    text="Play Again",
                    fontSize=16.sp,


                )

            }

        }
    }
}


@Composable
fun DrawVictoryLine(
    state:GameState
){
    when(state.victoryType){
        VictoryType.HL1 -> winHline1()
        VictoryType.HL2 -> winHline2()
        VictoryType.HL3 -> winHline3()
        VictoryType.VL1 -> winVline1()
        VictoryType.VL2 -> winVline2()
        VictoryType.VL3 -> winVline3()
        VictoryType.DL1 -> winDline1()
        VictoryType.DL2 -> winDline2()
        VictoryType.NONE -> {}
    }
}


@Preview
@Composable
fun Prev(){
    GameScreen(
        viewModel = GameViewModel()
    )
}