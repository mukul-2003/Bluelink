//package com.plcoding.bluelink.presentation
//
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Path
//import androidx.compose.ui.graphics.PathOperation
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Rect
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import kotlin.math.cos
//import kotlin.math.sin
//
//@Composable
//fun DrawMoonToSun(radius: Float, progress: Float, color: Color) {
//    Canvas(modifier = Modifier.fillMaxSize()) {
//        // Create the main circle
//        val mainCircle = Path().apply {
//            addOval(Rect(center, radius))
//        }
//
//        // Calculate the initial position of the subtracting circle
//        val initialOffset = center - Offset(radius * 2.3f, radius * 2.3f)
//
//        // Calculate the offset for the subtracting circle based on the progress
//        val offset = (radius * 1.8f) * progress
//
//        // Create the subtracting circle
//        val subtractCircle = Path().apply {
//            addOval(Rect(initialOffset + Offset(offset, offset), radius))
//        }
//
//        // Create the final path by subtracting the subtracting circle from the main circle
//        val moonToSunPath = Path().apply {
//            op(mainCircle, subtractCircle, PathOperation.Difference)
//        }
//
//        // Draw the resulting path with the specified color
//        drawPath(moonToSunPath, color)
//    }
//}
//
//@Composable
//fun DrawRays(
//    color: Color,
//    radius: Float,
//    rayWidth: Float,
//    rayLength: Float,
//    alpha: Float = 1f,
//    rayCount: Int = 8
//) {
//    Canvas(modifier = Modifier.fillMaxSize()) {
//        // Loop to draw each ray
//        for (i in 0 until rayCount) {
//            // Calculate the angle for the current ray
//            val angle = (2 * Math.PI * i / rayCount).toFloat()
//
//            // Calculate the starting position of the ray
//            val startX = center.x + radius * cos(angle)
//            val startY = center.y + radius * sin(angle)
//
//            // Calculate the ending position of the ray
//            val endX = center.x + (radius + rayLength) * cos(angle)
//            val endY = center.y + (radius + rayLength) * sin(angle)
//
//            // Draw the ray from the starting to the ending position
//            drawLine(
//                color = color,
//                start = Offset(startX, startY),
//                end = Offset(endX, endY),
//                strokeWidth = rayWidth
//            )
//        }
//    }
//}
//
//@Composable
//fun DrawStar(
//    color: Color,
//    centerOffset: Offset,
//    radius: Float,
//    alpha: Float = 1f
//) {
//    Canvas(modifier = Modifier.fillMaxSize()) {
//        val leverage = radius * 0.1f
//
//        val starPath = Path().apply {
//            // Move to the leftmost point of the star
//            moveTo(centerOffset.x - radius, centerOffset.y)
//
//            // Draw the upper left curve of the star
//            quadraticBezierTo(
//                x1 = centerOffset.x - leverage, y1 = centerOffset.y - leverage,
//                x2 = centerOffset.x, y2 = centerOffset.y - radius
//            )
//
//            // Draw the upper right curve of the star
//            quadraticBezierTo(
//                x1 = centerOffset.x + leverage, y1 = centerOffset.y - leverage,
//                x2 = centerOffset.x + radius, y2 = centerOffset.y
//            )
//
//            // Draw the lower right curve of the star
//            quadraticBezierTo(
//                x1 = centerOffset.x + leverage, y1 = centerOffset.y + leverage,
//                x2 = centerOffset.x, y2 = centerOffset.y + radius
//            )
//
//            // Draw the lower left curve of the star
//            quadraticBezierTo(
//                x1 = centerOffset.x - leverage, y1 = centerOffset.y + leverage,
//                x2 = centerOffset.x - radius, y2 = centerOffset.y
//            )
//        }
//
//        // Draw the star path
//        drawPath(starPath, color)
//    }
//}