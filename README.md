# MotionLayout
MotionLayout 是一种布局类型，可帮助您管理应用中的运动和微件动画。MotionLayout 是 ConstraintLayout 的子类，在其丰富的布局功能基础之上构建而成。作为 ConstraintLayout 库的一部分，MotionLayout 可用作支持库，并可向后兼容 API 级别 14

## 如何使用？

### 1.引入依赖库
    dependencies {
        implementation 'androidx.constraintlayout:constraintlayout:2.0.0-beta1'
    }
    
### 2.替换ConstraintLayout
   <!-- before: ConstraintLayout -->
    <androidx.constraintlayout.widget.ConstraintLayout .../>
    <!-- after: MotionLayout -->
    <androidx.constraintlayout.motion.widget.MotionLayout .../>
    
### 3. 创建 MotionScene
MotionScene 是一个 XML 资源文件，其中包含相应布局的所有运动描述。目的是为了<strong>将布局信息与运动描述分开</strong>，每个 MotionLayout 都引用一个单独的 MotionScene

    <?xml version="1.0" encoding="utf-8"?>
    <MotionScene xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:motion="http://schemas.android.com/apk/res-auto">

        <Transition
            motion:constraintSetStart="@+id/start"
            motion:constraintSetEnd="@+id/end"
            motion:duration="1000">
            <OnSwipe
                motion:touchAnchorId="@+id/button"
                motion:touchAnchorSide="right"
                motion:dragDirection="dragRight" />
        </Transition>

        <ConstraintSet android:id="@+id/start">
            <Constraint
                android:id="@+id/button"
                android:layout_width="64dp"
                android:layout_height="64dp"
                android:layout_marginStart="8dp"
                motion:layout_constraintBottom_toBottomOf="parent"
                motion:layout_constraintStart_toStartOf="parent"
                motion:layout_constraintTop_toTopOf="parent" />
        </ConstraintSet>

        <ConstraintSet android:id="@+id/end">
            <Constraint
                android:id="@+id/button"
                android:layout_width="64dp"
                android:layout_height="64dp"
                android:layout_marginEnd="8dp"
                motion:layout_constraintBottom_toBottomOf="parent"
                motion:layout_constraintEnd_toEndOf="parent"
                motion:layout_constraintTop_toTopOf="parent" />
        </ConstraintSet>
    </MotionScene>
    
    
## MotionScene 文件详解
### 1. 层级结构   
请参考 https://www.processon.com/view/link/60e7c72ce401fd047de6d808


### MotionScene元素
运动序列文件的根元素<strong>MotionScene</strong>元素 包含一个或多个 <strong>Transition</strong> 元素
<Transition> 必须包含的元素 
<ConstraintSet> 可以包含的元素 
defaultDuration 运动时间  

    
### Transition元素
1. 运动序列的开始和结束状态
2. 任何所需的中间状态
3. 触发该运动的用户交互（点击/滑动）
    
motion:constraintSetStart: 运动序列的初始状态。可以是 <ConstraintSet> 的 ID，也可以是布局。如需指定 <ConstraintSet>，请将此属性设置为 "@+id/constraintSetId"。如需指定布局，请设置为 “@layout/layoutState”。
    
motion:constraintSetEnd: 运动序列的最终状态。可以是 <ConstraintSet> 的 ID，也可以是布局。如需指定 <ConstraintSet>，请将此属性设置为 "@+id/constraintSetId"。如需指定布局，请设置为 “@layout/layoutState”。
    
motion:duration: 运动序列的时长，以毫秒为单位。如果未指定，则使用 <MotionScene> 元素的 defaultDuration。
   
    
可以包含的元素:
    
<strong>onClick</strong>:表示运动序列是由用户轻触触发的
    
<strong>onSwipe</strong>:表示运动序列是由用户滑动触发的
    
<strong>KeyFrameSet</strong>:用于为运动序列中的元素指定一个或多个中间位置或属性设置
    
    
### ConstraintSet元素
    
约束条件集合：运动序列中的某一点的位置和属性
    
可以通过deriveConstraintsFrom引用另一个 ConstraintSet 的 ID。如果指定此属性，相应集内的所有约束条件都将应用于此 ConstraintSet，除非此集明确替换它们。

    
   
## 参考链接
   1. 官网链接：https://developer.android.com/training/constraint-layout/motionlayout?hl=zh-cn
   2. demo链接 (views-widgets-samples/ConstraintLayoutExamples/motionlayout/)：https://github.com/githubforzjm/views-widgets-samples
   3. MotionLayout 简介（第 I 部分）https://medium.com/google-developers/introduction-to-motionlayout-part-i-29208674b10d
   4. MotionLayout 简介（第 II 部分）https://medium.com/google-developers/introduction-to-motionlayout-part-ii-a31acc084f59
   5. MotionLayout 简介（第 III 部分）https://medium.com/google-developers/introduction-to-motionlayout-part-iii-47cd64d51a5
   6. MotionLayout 简介（第 IV 部分）https://medium.com/google-developers/defining-motion-paths-in-motionlayout-6095b874d37
   7. KeyCycle 介绍 https://www.youtube.com/watch?v=qWmU6emSQ5k
   8. MotionLayout 视频介绍链接：https://www.youtube.com/channel/UCVHFbqXqoYvEWM1Ddxl0QDg
