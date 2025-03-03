#!/usr/bin/env python3

import pandas as pd
import plotly.express as px

def render_3d_scatter(file_path):
    columns = ['X', 'Y', 'Z', 'A']  # Define column names
    try:
        data = pd.read_csv(file_path, delim_whitespace=True, header=None, names=columns)

        # Create an interactive 3D scatter plot
        fig = px.scatter_3d(
            data,
            x='X',
            y='Y',
            z='Z',
            color='A',
            size_max=10,
            opacity=0.7,
            color_continuous_scale='Viridis',
            title="3D Scatter Plot"
        )
        fig.update_layout(scene=dict(xaxis_title='X', yaxis_title='Y', zaxis_title='Z'))
        fig.show()
    except FileNotFoundError:
        print("File not found. Please check the path and try again.")
    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    file_path = input("Enter the path to your .xyza file: ")
    render_3d_scatter(file_path)

