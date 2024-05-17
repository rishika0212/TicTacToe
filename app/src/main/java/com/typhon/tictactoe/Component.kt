package com.typhon.tictactoe

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.typhon.tictactoe.ui.theme.Aqua
import com.typhon.tictactoe.ui.theme.GrayLine
import com.typhon.tictactoe.ui.theme.ParrotGreen
import com.typhon.tictactoe.ui.theme.Red

@Composable
fun BoardBase(){
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp),

    ){
        drawLine(
            color= GrayLine,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x=size.width*1/3,y=0f),
            end = Offset(x=size.width*1/3,y=size.height)
        )
        drawLine(
            color= GrayLine,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x=size.width*2/3,y=0f),
            end = Offset(x=size.width*2/3,y=size.height)
        )
        drawLine(
            color= GrayLine,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x=0f,y=size.width*1/3),
            end = Offset(x=size.height,y=size.width*1/3)
        )
        drawLine(
            color= GrayLine,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x=0f,y=size.width*2/3),
            end = Offset(x=size.height,y=size.width*2/3)
        )
    }

}

@Composable
fun Cross(){
    Canvas(
        modifier= Modifier
            .size(60.dp)
            .padding(5.dp)

    ){
        drawLine(
            color= ParrotGreen,
            strokeWidth=20f,
            cap= StrokeCap.Round,
            start=Offset(x=0f,y=0f),
            end= Offset(x=size.width,y=size.height)
        )
        drawLine(
            color= ParrotGreen,
            strokeWidth=20f,
            cap= StrokeCap.Round,
            start=Offset(x=0f,y=size.height),
            end= Offset(x=size.width,y=0f)
        )
    }
}

@Composable
fun Circle(){
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawCircle(
            color= Aqua,
            style= Stroke(width=20f)
        )

    }
}

@Composable
fun winVline1(){
    Canvas(
        modifier=Modifier
            .size(300.dp)
    ){
        drawLine(
            color= Red,
            strokeWidth=10f,
            cap=StrokeCap.Round,
            start = Offset(x=size.width*1/6,y=0f),
            end = Offset(x=size.width*1/6,y=size.height)

        )
    }
}
@Composable
fun winVline2(){
    Canvas(
        modifier=Modifier
            .size(300.dp)
    ){
        drawLine(
            color= Red,
            strokeWidth=10f,
            cap=StrokeCap.Round,
            start = Offset(x=size.width*1/2,y=0f),
            end = Offset(x=size.width*1/2,y=size.height)

        )
    }
}
@Composable
fun winVline3(){
    Canvas(
        modifier=Modifier
            .size(300.dp)
    ){
        drawLine(
            color= Red,
            strokeWidth=10f,
            cap=StrokeCap.Round,
            start = Offset(x=size.width*5/6,y=0f),
            end = Offset(x=size.width*5/6,y=size.height)

        )
    }
}


@Composable
fun winHline1(){
    Canvas(
        modifier=Modifier
            .size(300.dp)
    ){
        drawLine(
            color= Red,
            strokeWidth=10f,
            cap=StrokeCap.Round,
            start = Offset(y=size.width*1/6,x=0f),
            end = Offset(y=size.width*1/6,x=size.height)

        )
    }
}
@Composable
fun winHline2(){
    Canvas(
        modifier=Modifier
            .size(300.dp)
    ){
        drawLine(
            color= Red,
            strokeWidth=10f,
            cap=StrokeCap.Round,
            start = Offset(y=size.width*1/2,x=0f),
            end = Offset(y=size.width*1/2,x=size.height)

        )
    }
}
@Composable
fun winHline3(){
    Canvas(
        modifier=Modifier
            .size(300.dp)
    ){
        drawLine(
            color= Red,
            strokeWidth=10f,
            cap=StrokeCap.Round,
            start = Offset(y=size.width*5/6,x=0f),
            end = Offset(y=size.width*5/6,x=size.height)

        )
    }
}
@Composable
fun winDline1(){
    Canvas(
        modifier=Modifier
            .size(300.dp)
    ){
        drawLine(
            color= Red,
            strokeWidth=10f,
            cap=StrokeCap.Round,
            start = Offset(x=0f,y=0f),
            end = Offset(x=size.width,y=size.height)

        )
    }
}
@Composable
fun winDline2(){
    Canvas(
        modifier=Modifier
            .size(300.dp)
    ){
        drawLine(
            color= Red,
            strokeWidth=10f,
            cap=StrokeCap.Round,
            start = Offset(x=0f,y=size.height),
            end = Offset(x=size.width,y=0f)

        )
    }
}




@Preview
@Composable
fun Previews(){
    BoardBase()
    winHline1()
    winHline2()
    winHline3()
    winVline1()
    winVline2()
    winVline3()
    winDline1()
    winDline2()
}