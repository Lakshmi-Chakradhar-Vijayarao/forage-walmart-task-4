import sqlite3
import csv
import os

# Path to CSV file inside the data folder
csv_file_path = os.path.join("data", "shipping_data_0.csv")

# Connect to the SQLite database (it will create the file if not exists)
conn = sqlite3.connect("shipment_database.db")
cursor = conn.cursor()

# Drop the old shipment table if it exists
cursor.execute("DROP TABLE IF EXISTS shipment;")

# Create the shipment table with the required columns
cursor.execute("""
CREATE TABLE shipment (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    origin_warehouse TEXT NOT NULL,
    destination_store TEXT NOT NULL,
    product TEXT NOT NULL,
    on_time BOOLEAN NOT NULL,
    product_quantity INTEGER NOT NULL,
    driver_identifier TEXT NOT NULL
);
""")

# Open and read the CSV file
with open(csv_file_path, newline='') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        cursor.execute("""
            INSERT INTO shipment 
            (origin_warehouse, destination_store, product, on_time, product_quantity, driver_identifier)
            VALUES (?, ?, ?, ?, ?, ?)
        """, (
            row["origin_warehouse"],
            row["destination_store"],
            row["product"],
            row["on_time"].lower() == "true",
            int(row["product_quantity"]),
            row["driver_identifier"]
        ))

# Commit changes and close connection
conn.commit()
conn.close()

print("✅ Data inserted successfully from shipping_data_0.csv")
