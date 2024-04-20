import re
import os
from pathlib import Path

def strip(line):
    return line.rstrip('\n')

def get_title(title, link):
    return "# [{0}]({1})\n".format(title, link)

def get_details(lines):
    new_lines = lines[2:]
    for i, line in enumerate(new_lines):
        if line.startswith("------"):
            return ["### Problem Statement\n"] + new_lines[:i] + ["\n"]


def get_examples(lines):
    indexes = [i for i, val in enumerate(lines) if val.strip().startswith("Example ")]
    example = []
    for i in range(len(indexes)):
        example.append("#### {0}\n".format(lines[indexes[i]]))
        example_details = lines[indexes[i] + 1 : indexes[i + 1]] if i + 1 < len(indexes) else lines[indexes[i]+1:]
        example_details = [detail for detail in example_details if len(strip(detail)) > 0]
        example.append("```\n")
        example += example_details
        example.append("\n```\n")

    return example


def get_java_code(category, fileName):
    java_file_path = "./src/main/java/org/example/{0}/{1}".format(category, fileName)
    java_file_path_readme = "../../src/main/java/org/example/{0}/{1}".format(category, fileName)
    solution = ["### Solution\n\n[{0}]({1})\n\n".format(fileName, java_file_path_readme)]
    with open(java_file_path) as file:
        solution.append("```java\n")
        solution += file.readlines()
        solution.append("\n```")
        return solution


def get_out_file_path(category, title):
    file_name = "-".join(title.lower().split(" "))+".md"
    return "problems/{0}/{1}".format(category, file_name)


def write_readme(file_path, title, link, details, examples, code) :
    os.makedirs(os.path.dirname(file_path), exist_ok=True)
    with open(file_path, "w") as writer:
        writer.writelines(title)
        writer.writelines(link)
        writer.writelines(["\n<hr />\n\n"])
        writer.writelines(details)
        writer.writelines(examples)
        writer.writelines(["\n<hr />\n\n"])
        writer.writelines(code)


if __name__ == '__main__':
    file_path = "temp.txt"

    # update these variables as per requirement
    category= "graph"
    package_name = "graph"
    java_file="IslandMaxArea.java"

    with open(file_path) as file:
        lines = file.readlines()
        link = strip(lines[1])
        write_readme(
            get_out_file_path(category, strip(lines[0])), #Category as in problems/category/<..>.md
            get_title(strip(lines[0]), link),
            link,
            get_details(lines),
            get_examples(lines),
            get_java_code( package_name, java_file)  # packagename and filename
        )




