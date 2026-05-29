package com.mindlesstoys.stick404.astral_aaa;

import org.joml.Vector2f;
import org.joml.Vector2i;

import javax.annotation.Nullable;
import java.util.*;

public class ConstellationShape {
    static {
        ConstellationShape exampleConst = new ConstellationBuilder().newPoint(0f, 0f).build();
    }

    /// Declares the stars within this Constellation
    private final List<Vector2f> points;
    /// Declares the indexes in {@link ConstellationShape#points} to connect. This is bidirectional
    private final List<Vector2i> lines;

    private ConstellationShape(List<Vector2f> points, List<Vector2i> lines) {
        this.lines = lines;
        this.points = points;
    }

    public @Nullable ConstellationShape create(List<Vector2f> points, List<Vector2i> lines) {
        HashSet<Integer> checkedIndex = new HashSet<>();
        Stack<Integer> toCheck = new Stack<>();
        if (lines.isEmpty() || points.isEmpty()) {
            return null;
        }
        toCheck.push(0);

        while (!toCheck.isEmpty()) {
            Integer check = toCheck.pop();
            if (checkedIndex.contains(check)) {
                continue;
            }
            checkedIndex.add(check);

        }

        return new ConstellationShape(points, lines);
    }

    public static class ConstellationBuilder {
        /// Declares the stars that will be used
        private final ArrayList<Vector2f> points;
        /// Declares the indexes in {@link ConstellationBuilder#points} to connect. This is bidirectional
        private final ArrayList<Vector2i> lines;



        public ConstellationBuilder(){
            this.points = new ArrayList<>();
            this.lines = new ArrayList<>();
        }

        public ConstellationBuilder newPoint(float f1, float f2){
            this.points.add(new Vector2f(f1, f2));
            return this;
        }

        public ConstellationBuilder newPoint(Vector2f vec){
            this.points.add(vec);
            return this;
        }

        public ConstellationBuilder newConnection(int i, int i2){
            this.lines.add(new Vector2i(i, i2));
            return this;
        }

        public ConstellationShape build(){
            return new ConstellationShape(this.points, this.lines);
        }
    }
}
