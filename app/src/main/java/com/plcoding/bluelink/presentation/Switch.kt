//import androidx.compose.animation.core.AnimationSpec
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.layout.aspectRatio
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.drawscope.rotate
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.plcoding.bluelink.presentation.DrawRays
//import com.plcoding.bluelink.presentation.DrawStar
//import com.plcoding.bluelink.presentation.DrawMoonToSun
//
//@Composable
//fun MoonToSunSwitcher(
//    isMoon: Boolean,
//    color: Color,
//    modifier: Modifier = Modifier,
//    animationSpec: AnimationSpec<Float> = tween(400)
//) {
//    // Animate progress based on the target value
//    val progress by animateFloatAsState(
//        targetValue = if (isMoon) 1f else 0f,
//        animationSpec = animationSpec
//    )
//
//    Canvas(
//        modifier = modifier
//            .size(100.dp) // Set a default size of the Canvas
//            .aspectRatio(1f) // Ensure the Canvas maintains a 1:1 aspect ratio
//    ) {
//        val width = size.width
//        val height = size.height
//        val baseRadius = width * 0.25f
//        val extraRadius = width * 0.2f * progress
//        val radius = baseRadius + extraRadius
//
//        // Rotate canvas based on the progress
//        rotate(180f * (1 - progress)) {
//            // Calculate progress for drawing rays
//            val raysProgress = if (progress < 0.5f) (progress / 0.85f) else 0f
//
//            // Draw rays for the sun shape
//            DrawRays(
//                color = color,
//                alpha = if (progress < 0.5f) 1f else 0f,
//                radius = (radius * 1.5f) * (1f - raysProgress),
//                rayWidth = radius * 0.3f,
//                rayLength = radius * 0.2f
//            )
//
//            // Draw the transition between moon and sun shape
//            DrawMoonToSun(radius, progress, color)
//        }
//
//        // Calculate progress for drawing stars
//        val starProgress = if (progress > 0.8f) ((progress - 0.8f) / 0.2f) else 0f
//
//        // Draw stars for the moon
//        DrawStar(
//            color = color,
//            centerOffset = Offset(width * 0.4f, height * 0.4f),
//            radius = (height * 0.05f) * starProgress,
//            alpha = starProgress
//        )
//        DrawStar(
//            color = color,
//            centerOffset = Offset(width * 0.2f, height * 0.2f),
//            radius = (height * 0.1f) * starProgress,
//            alpha = starProgress
//        )
//    }
//}
